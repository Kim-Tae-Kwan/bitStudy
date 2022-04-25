package logginF;

import org.apache.log4j.Logger;

public class Ex02 {
	Logger log = Logger.getLogger("com.bit.Ex02");
	
	public void func01() {
		log.trace("몰라 메시지");
		log.debug("디버그 모드 메시지");
		log.info("정보 모드 메시지");
		log.warn("주의 모드 메시지");
		log.error("에러 모드 메시지");
		log.fatal("심각 모드 메시지");
	}
}
