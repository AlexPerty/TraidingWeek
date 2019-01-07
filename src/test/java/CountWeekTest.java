package com.jakitydzien2;

import com.jakitydzien2.home.WeekController;
import junit.framework.TestCase;
import org.junit.Test;

public class CountWeekTest extends TestCase{

  @Test
  public void testHandlowy(){
    assertEquals(WeekController.countingWeek(4), true);
    assertEquals(WeekController.countingWeek(13), true);
    assertEquals(WeekController.countingWeek(47), true);
  }

  @Test
  public void testNieHandlowy(){
    assertEquals(WeekController.countingWeek(5), false);
    assertEquals(WeekController.countingWeek(14), false);
    assertEquals(WeekController.countingWeek(100000), false);
    assertEquals(WeekController.countingWeek(-1), false);
  }

} 