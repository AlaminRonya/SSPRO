package com.alamin.InterceptorDemo.model;

public record RequestTracker(
        String ip,
        String method,
        String path,
        String pageName,
        String time,
        String thread,
        long consumedTime
) {
}
