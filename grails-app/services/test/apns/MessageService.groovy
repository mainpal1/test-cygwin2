package test.apns

import com.notnoop.apns.APNS
import com.notnoop.apns.ApnsNotification
import com.notnoop.apns.ApnsService
class MessageService {

	boolean transactional = true

	ApnsService apnsService 
	def sendMessageToDevices(List<Device> recipients, String messageKey, Collection<String> arguments) {
		recipients?.each {Device device ->
			def payload = APNS.newPayload()
					.badge(device.messages.size())
					.localizedKey(messageKey)
					.localizedArguments(arguments)
					.sound("default")
			if (payload.isTooLong()) log.info("Message is too long: " + payload.length())
			try {
				apnsService.push( device.token, payload.build().getBytes("UTF-8"))
			} catch (Exception e) {
				log.error("Could not connect to APNs to send the notification")
			}
		}
         
	}
	
	
	def test1(def xi,def x2){
		
		
		
		return [xi, x2]
	}
	
}