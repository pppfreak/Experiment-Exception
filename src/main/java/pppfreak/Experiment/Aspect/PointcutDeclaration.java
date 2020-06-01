package pppfreak.Experiment.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class PointcutDeclaration {

    private Logger logger = Logger.getLogger(getClass().getName());
    //execution(* pppfreak.Experiment.Controller.EmployeeServiceImpl.(..))

    @Pointcut("within(pppfreak.Experiment.Controller..*)")
    private void forControllerPackage(){}


    //@Around(pointcut="forControllerPackage()",throwing = "e")
    @AfterThrowing(pointcut = "forControllerPackage()", throwing = "e")
    private void aroundHandleException(JoinPoint proceedingJoinPoint, Throwable e){


        String method = proceedingJoinPoint.getSignature().toShortString();

        logger.info("The method that executed "+method);
        Object result;
        try {
            //result = proceedingJoinPoint.proceed();
        } catch (Exception throwable) {
            logger.warning("Employee not found by this "+throwable.getMessage());
            logger.info(method);
        }

    }
}
