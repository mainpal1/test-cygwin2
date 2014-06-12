package test.apns    




import javapns.Push;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;
import javapns.notification.transmission.PushQueue;



//TEST	
import com.notnoop.apns.ApnsService
class DeviceController {
	ApnsService apnsService
	def index = {
		for (int i=0;i<3;i++){
		String messages="x Test "
		String	keystore = "C:\\Users\\Sid\\Downloads\\APNS_PictureApp\\PictureAppCertificates.p12"
		String	password = "passw0rd"
		PushNotificationPayload payload = PushNotificationPayload.complex();
		 payload.addAlert(messages);
		 payload.addBadge(1)
		 payload.addCustomDictionary("shareId", "1."+i);
		 String devices = "4c27dd01 5ea607f1 0b9e0f94 c8f0f682 a4758628 ce2a10cd 02333cf0 72888af0".replaceAll("\\s+","") ;
		 BasicDevice db= new BasicDevice(devices)
		 List<PushedNotification> notifications = Push.payload(payload, keystore, password, false, db)
		 println ""+new Date()+""+notifications
	}
		//for (int i=0;i<100;i++){
		/*
			boolean production = false;
			 Prepare a simple payload to push 
			PushNotificationPayload payload = PushNotificationPayload.alert(messages+""+i);
			payload.addBadge(1)
			 Decide how many threads you want your queue to use 
			int threads = 30;

			payload.addCustomDictionary("shareId",""+ i);


			 Create the queue 
			PushQueue queue = Push.queue(keystore, password, production, threads);


			 Start the queue (all threads and connections and initiated) 
			queue.start();

			String devices = "4c27dd01 5ea607f1 0b9e0f94 c8f0f682 a4758628 ce2a10cd 02333cf0 72888af0".replaceAll("\\s+","") ;
			 Add a notification for the queue to push 
			queue.add(payload, devices);
		*/
	}
}
