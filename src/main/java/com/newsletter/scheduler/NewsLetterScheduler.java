package com.newsletter.scheduler;

import static com.newsletter.helper.NewsLetterHelper.prepareNewsLetter;
import static com.newsletter.util.CalandarUtil.isEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.newsletter.domain.Employee;
import com.newsletter.model.NewsLetterType;
import com.newsletter.service.EmployeeService;
import com.newsletter.service.NewsLetterService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class NewsLetterScheduler {

	private static final String EXECUTION_STARTED = "Job execution has started ::: {}";
	private static final String EXECUTION_SUCCESS = "Job execution has completed ::: {}";
	private static final String BIRTHDAY_NOTIFICATION_SENT = "Birthday notification has been successfully sent for the employee {}";
	private static final String ANNIVERSARY_NOTIFICATION_SENT = "Anniversary notification has been successfully sent for the employee {}";
	private static final String EXECUTION_BIRTHDAY_JOB_FAILED = "Job execution has failed while sending birthday notification for employee {}, {}";
	private static final String EXECUTION_ANNIVERSARY_JOB_FAILED = "Job execution has failed while sending anniversary notification for employee {}, {}";

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private NewsLetterService newsLetterService;

	@Scheduled(cron = "0 0 0 * * ?")
	public void scheduleNewLetterJob() {
		log.info(EXECUTION_STARTED, LocalDateTime.now().toString());

		List<Employee> employees = employeeService.getAllEmployees();
		List<Employee> birthdayEmployees = new ArrayList<>();
		List<Employee> anniversaryEmployees = new ArrayList<>();

		employees.forEach(employee -> {
			if (isEquals.test(employee.getDateOfBirth())) {
				birthdayEmployees.add(employee);
			}

			if (isEquals.test(employee.getJoiningDate()) && employee.getIsActive()) {
				anniversaryEmployees.add(employee);
			}
		});

		birthdayEmployees.forEach(employee -> {
			try {
				newsLetterService.sendNewsLetter(prepareNewsLetter(employee, NewsLetterType.BIRTHDAY));
				log.info(BIRTHDAY_NOTIFICATION_SENT, employee.getEmpId());
			} catch (Exception e) {
				log.error(EXECUTION_BIRTHDAY_JOB_FAILED, employee.getEmpId(), e);
			}
		});

		anniversaryEmployees.forEach(employee -> {
			try {
				newsLetterService.sendNewsLetter(prepareNewsLetter(employee, NewsLetterType.ANNIVERSARY));
				log.info(ANNIVERSARY_NOTIFICATION_SENT, employee.getEmpId());
			} catch (Exception e) {
				log.error(EXECUTION_ANNIVERSARY_JOB_FAILED, employee.getEmpId(), e);
			}
		});

		log.info(EXECUTION_SUCCESS, LocalDateTime.now().toString());
	}

}
