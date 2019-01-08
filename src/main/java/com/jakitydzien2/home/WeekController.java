package com.jakitydzien2.home;

/**
 * Created by Perty on 07-Jan-19.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.IsoFields;
import java.util.Arrays;
import java.util.List;

@Controller
public class WeekController {
  private static final List<Integer> allowedTradingWeeks = Arrays.asList(4,8,13,15,17,21,26,30,34,39,43,47,50,51,52);
  
  public static boolean countingWeek(Integer weekNr) {    
    return allowedTradingWeeks.contains(weekNr);
  }
  public static boolean pairWeek(Integer weekNr) {
    return weekNr % 2 == 0;
  }

  @GetMapping("/")
  private ModelAndView greeting(@RequestParam(value = "value", required = false) Integer value) {
    ModelAndView modelAndView = new ModelAndView("greeting");
    
    if (value == null) {
      ZonedDateTime now = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
      value = now.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
    }
    
    modelAndView.addObject("whatWeek", countingWeek(value) ? "niedziela handlowa" : "niedziela niehandlowa");
    modelAndView.addObject("pairWeek", pairWeek(value) ? "niedziela parzysta" : "niedziela nie parzysta");
    
    return modelAndView;
  }

}



