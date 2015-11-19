package mx.com.openweathermap.exceptions;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by beto on 18/11/15.
 */
@Aspect
public class SnapshotExceptionHandlerAspect {

  private static final Logger LOG = LoggerFactory.getLogger(SnapshotExceptionHandlerAspect.class);


  public void handleSeleniumException(JoinPoint jp, RuntimeException exception){

    /*
    LOG.debug("Error en BD, método :{}.{}, con args: {}. Stacktrace: {}",
            jp.getSignature().getDeclaringTypeName(),
            jp.getSignature().getName(),
            Arrays.toString(jp.getArgs()),
            ExceptionUtils.getStackTrace(exception));
    */
  }



}
