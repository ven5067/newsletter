package com.newsletter.scheduler;

import static com.newsletter.helper.NewsLetterHelper.prepareNewsLetter;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.newsletter.domain.Employee;
import com.newsletter.service.EmployeeService;
import com.newsletter.service.NewsLetterService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class NewsLetterScheduler {

	private static final String EXECUTION_STARTED = "Job execution has started ::: {}";
	private static final String EXECUTION_SUCCESS = "Job execution has completed ::: {}";
	private static final String EXECUTION_FAILED = "Job execution has failed for employee {}, {}";

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private NewsLetterService newsLetterService;

	@Scheduled(cron = "0 0 0 * * ?")
	public void scheduleNewLetterJob() {
		log.info(EXECUTION_STARTED, LocalDateTime.now().toString());
		List<Employee> employees = employeeService.getAllEmployees();
		employees.forEach(employee -> {
			try {
				newsLetterService.sendNewsLetter(prepareNewsLetter(employee));
			} catch (Exception e) {
				log.error(EXECUTION_FAILED, employee.getEmpId(), e);
			}
		});
		log.info(EXECUTION_SUCCESS, LocalDateTime.now().toString());
	}

}
