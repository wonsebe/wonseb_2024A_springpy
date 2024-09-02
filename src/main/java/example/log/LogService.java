package example.log;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LogService {
//    @Autowired LogDao logDao;

    public  void log(){
        //1.
        log.info("logController info log");
        //2.
        log.debug("logController debug log");
        //3.
        log.warn("logController warn log");
        //4.
        log.error("logController error log");
    }
}
