/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author kevinschorkops
 */
public class CurrentTimeId {

    private CurrentTimeId() {
    }

    private static AtomicReference<Long> currentTime = new AtomicReference<>(System.currentTimeMillis());

    public static Long nextId() {
        return currentTime.accumulateAndGet(System.currentTimeMillis(), (prev, next) -> next > prev ? next : prev + 1);
    }
}
