package org.kkorbacz.pitfalls

fun main(args: Array<String>) {

//    when {
//        log.isDebugEnabled -> LoggingInInterceptor()
//                .let {
//                    loggingInInterceptor ->
//                        loggingInInterceptor.setPrettyLogging(true)
//                        loggingInInterceptor
//                }
//                .let {
//                    loggingInInterceptor ->
//                        soapClientFactory.inInterceptors.add(loggingInInterceptor)
//                }
//    }

// vs

//if (log.isDebugEnabled) {
//    val loggingInInterceptor = LoggingInInterceptor()
//    loggingInInterceptor.setPrettyLogging(true)
//    soapClientFactory.inInterceptors.add(loggingInInterceptor)
//}

}