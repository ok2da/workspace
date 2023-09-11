package com.naver.myhome4.task;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.naver.myhome4.service.BoardService;

@Service
@EnableScheduling	// �Ʒ��� Ŭ������ �����층 �������� ����ϵ��� �ϰڴٴ� ����մϴ�. @Configuration�� ���� ����ؾ� �մϴ�.
@Configuration		// �� ������̼��� ������� ������ �����층�� �������� �ʽ��ϴ�.
public class FileCheckTask {

	private static final Logger logger = LoggerFactory.getLogger(FileCheckTask.class);
	
	@Value("${savefoldername}")
	private String saveFolder;
	
	private BoardService boardService;
	
	@Autowired
	public FileCheckTask(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// �����췯�� �̿��ؼ� �ֱ������� �޼��鸣 �����ϱ� ���� �����մϴ�.
	// 1000 : �и������� �����Դϴ�. (1��)
	//@Scheduled(fixedDelay=1000)
	public void test() throws Exception{
		logger.info("test");
	}
	
	// cron ����
	// seconds(��:0~59) minutes(��:0~59) hours(��:0~23) day(��:1~31)
	// months(��:1~12) day of week(����:0~6) year(optional)
	//					��	��	��	��	��	����
	@Scheduled(cron =	"0 	9 	* 	* 	* 	* 	")
	public void checkFiles() throws Exception {
	      
		logger.info("checkFiles");
	      
		List<String> deleteFileList = boardService.getDeleteFileList();
	      
	    // for(String filename : deletefileList) {
	    for ( int i = 0; i < deleteFileList.size(); i++ ) {
	       String filename = deleteFileList.get(i);
	       File file = new File(saveFolder + filename);
	       if(file.exists()) {
	          if(file.delete()) {
	             logger.info(file.getPath() + " ���� �Ǿ����ϴ�.");
	             boardService.deleteFileList(filename);
	          }
	       } else {
	          logger.info(file.getPath() + " ������ �������� �ʽ��ϴ�.");
	       }
	   }
	}
	
}
