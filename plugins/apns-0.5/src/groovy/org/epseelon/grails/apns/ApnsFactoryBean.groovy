package org.epseelon.grails.apns

import org.springframework.beans.factory.FactoryBean
import com.notnoop.apns.APNS
import com.notnoop.apns.ApnsService

/**
 * @author sarbogast
 * @version 1 janv. 2010, 00:37:38
 */
class ApnsFactoryBean implements FactoryBean {
    public enum Environment{SANDBOX, PRODUCTION}

    String pathToCertificate
    String password
    boolean queued = false
    Environment environment = Environment.SANDBOX
    boolean nonBlocking = false

    Object getObject() {
        def apnsService = APNS.newService().withCert(pathToCertificate, password)
		
        switch(environment){
            case Environment.PRODUCTION: 
				apnsService = apnsService.withProductionDestination(); break;
            case Environment.SANDBOX:
            default: 
				apnsService = apnsService.withSandboxDestination(); break;
        }
		
		/*
		 * Apns, nowadays, is just supporting Queued service. 
		 * Was talking to the developer of the API, and he told me that furtermore
		 * even the method asNonBlocking might be removed!
		 */
		  
        apnsService = apnsService.asQueued()

        return apnsService.build()
    }

    Class getObjectType() { ApnsService }

    boolean isSingleton() { true }
}
