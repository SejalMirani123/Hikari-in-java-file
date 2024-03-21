package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.concurrent.*;


@RestController
@RequestMapping("/api")
public class YourController {

    @Autowired
    private YourDao yourDao;

    @PostMapping("/insert")
    public String insertData(@RequestBody YourDataDTO yourData) throws SQLException {
        //ExecutorService submit a task to be executed in the background
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            yourDao.insert(yourData);
            return "Data inserted successfully!";
        });
        try {
            //This method waits for the background task  to finish execution and then retrieves its return value
            String result = future.get(1, TimeUnit.MICROSECONDS);
            return result;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            future.cancel(true);
            return "Query execution timed out!";
        } finally {
            executorService.shutdown();
        }
    }




//    @PostMapping("/insert")
//    public String insertData(@RequestBody YourDataDTO yourData) throws SQLException {
//        yourDao.insert(yourData);
//        return "Data inserted successfully!";
//    }


}
