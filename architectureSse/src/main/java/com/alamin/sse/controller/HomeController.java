//package com.alamin.sse.controller;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//import java.io.IOException;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//@Controller
//@Slf4j
//public class HomeController {
//    private final ExecutorService executorService = Executors.newCachedThreadPool();
////    @ResponseBody
////    @GetMapping("/get-progress")
////    public void getProgress(HttpServletResponse response) throws IOException {
////        var writter = response.getWriter();
////        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
////        for (int i = 0; i < 100; i++) {
////            writter.println(i + "%");
////            writter.flush();
////            sleep(100);
////        }
////    }
////    private void sleep(long millis) {
////        try {
////            Thread.sleep(millis);
////        }catch (InterruptedException e){
////
////        }
////    }
//
////    @ResponseBody
////    @GetMapping("/get-progress")
////    public SseEmitter getProgress(HttpServletResponse response) throws IOException {
////        SseEmitter emitter = new SseEmitter((long) Integer.MAX_VALUE);
////        Executors.newCachedThreadPool().execute(() -> {
////            for (int i = 0; i < 100; i++) {
////                try {
////                    emitter.send(i+"%");
////                    sleep(1000);
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            }
////        });
////
////        return emitter;
////    }
//    @GetMapping("/get-progress")
//    public SseEmitter getProgress(HttpServletResponse response) {
//        SseEmitter emitter = new SseEmitter((long) Integer.MAX_VALUE);
//
//        executorService.execute(() -> {
//            try {
//                for (int i = 0; i < 100; i++) {
//                    emitter.send(i + "%");
//                    sleep(1000);
//                }
//                emitter.complete();
//            } catch (IOException e) {
//                log.error("Error sending SSE event", e);
//                emitter.completeWithError(e);
//            }
//        });
//
//        return emitter;
//    }
//    private void sleep(long millis) {
//        try {
//            Thread.sleep(millis);
//        }catch (InterruptedException e){
//
//        }
//    }
//}


package com.alamin.sse.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.apache.catalina.connector.ClientAbortException;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@Slf4j
public class HomeController {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @GetMapping("/get-progress")
    public SseEmitter getProgress(HttpServletResponse response) {
        SseEmitter emitter = new SseEmitter((long) Integer.MAX_VALUE);

        executorService.execute(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    try {
                        emitter.send(i + "%");
                        sleep(1000);
                    } catch (IOException e) {
                        if (e.getCause() instanceof ClientAbortException) {
                            log.info("Client disconnected");
                        } else {
                            log.error("Error sending SSE event", e);
                        }
                        emitter.completeWithError(e);
                        return;
                    }
                }
                emitter.complete();
            } catch (Exception e) {
                log.error("Unexpected error in SSE stream", e);
                emitter.completeWithError(e);
            }
        });

        return emitter;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread sleep interrupted", e);
        }
    }
}
