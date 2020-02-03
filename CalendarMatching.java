package com;

import java.lang.reflect.Array;
import java.util.*;

public class CalendarMatching {

	public static void main(String[] args) {
		List <StringMeeting> cal1= new ArrayList<>();
		cal1.add(new StringMeeting("9:00", "10:30"));
		cal1.add(new StringMeeting("12:00", "13:00"));
		cal1.add(new StringMeeting("16:00", "18:00"));
		
		StringMeeting db1= new StringMeeting("8:00", "20:00");
		
		List <StringMeeting> cal2= new ArrayList<>();
		cal2.add(new StringMeeting("10:00", "11:30"));
		cal2.add(new StringMeeting("12:30", "14:30"));
		cal2.add(new StringMeeting("14:30", "15:00"));
		cal2.add(new StringMeeting("16:00", "17:00"));
		
		StringMeeting db2= new StringMeeting("7:00", "18:30");
		
		List<StringMeeting> freeTime=calendarMatching(cal1, db1, cal2, db2, 45);
		
		
		freeTime.forEach(M -> {
			System.out.print(M.start + " " + M.end);
			System.out.println(" ");
		});
		

	}
	
	public static List<StringMeeting> calendarMatching(List<StringMeeting> calendar1,StringMeeting dailyBounds1,List<StringMeeting> calendar2,StringMeeting dailyBounds2,int meetingDuration) {
		    // Write your code here.
		 
		 List<StringMeeting> updatedCal1 =  new ArrayList<StringMeeting>();
		 updatedCal1.add(new StringMeeting("0:00", dailyBounds1.start));
		 updatedCal1.addAll(calendar1);
		 updatedCal1.add(new StringMeeting(dailyBounds1.end,"23:59"));
		 
		 List<StringMeeting> updatedCal2 =  new ArrayList<StringMeeting>();
		 updatedCal2.add(new StringMeeting("0:00", dailyBounds2.start));
		 updatedCal2.addAll(calendar2);
		 updatedCal2.add(new StringMeeting(dailyBounds2.end,"23:59"));
		 List<Meeting> convertCalendar1= convertingCalendar(updatedCal1);
		 System.out.println(" ");
		 List<Meeting> convertCalendar2= convertingCalendar(updatedCal2);
		 List<Meeting> mergedCalendar= mergingCalendar(convertCalendar1,convertCalendar2);
		 
		 List<Meeting> flatCalendar= flatteningCalendar(mergedCalendar);
		 return findAvlblSlots(flatCalendar,meetingDuration);
		 
	}
	
	
	private static List<StringMeeting> findAvlblSlots(List<Meeting> flatCalendar, int meetingDuration) {

		List<Meeting> avlblSlots= new ArrayList<Meeting>();
		for(int i=1;i<flatCalendar.size();i++) {
			int start= flatCalendar.get(i-1).getEnd();
			int end= flatCalendar.get(i).getStart();
			
			if(Math.abs(start-end) >= meetingDuration) {
				avlblSlots.add(new Meeting(start,end));
			}
		}
		
		List<StringMeeting> avblslot= minsToTime(avlblSlots);
		return avblslot;
	}

	private static List<StringMeeting> minsToTime(List<Meeting> avlblSlots) {
		
		List<StringMeeting> finalSlots= new ArrayList<>();
		for(int i=0;i< avlblSlots.size();i++) {
			Meeting m = avlblSlots.get(i);
			int start=m.getStart();
			int end= m.getEnd();
			String startHrs= Math.floorDiv(start, 60) >=10 ? String.valueOf(Math.floorDiv(start, 60)) : "0"+String.valueOf(Math.floorDiv(start, 60)) ;
			String startMin= (start%60) >=10 ? String.valueOf(start%60) : "0"+String.valueOf(start%60) ;
			
			String startTime= startHrs+":"+startMin;
			
			String endHrs= Math.floorDiv(end, 60) >=10 ? String.valueOf(Math.floorDiv(end, 60)) : "0"+String.valueOf(Math.floorDiv(end, 60)) ;
			String endMin= (end%60) >=10 ? String.valueOf(end%60) : "0"+String.valueOf(end%60) ;
			//String endTime= String.valueOf(Math.floorDiv(end, 60))+":"+String.valueOf(end%60);
			String endTime= endHrs+":"+endMin;
			finalSlots.add(new StringMeeting(startTime, endTime));
			
		}
		return finalSlots;
	}

	private static List<Meeting> flatteningCalendar(List<Meeting> mergedCalendar) {
		//System.out.println("hey");
		List<Meeting> flatCalendar= new ArrayList<>();
		flatCalendar.add(mergedCalendar.get(0));
		for(int i=1;i< mergedCalendar.size();i++) {
			
			Meeting current= mergedCalendar.get(i);
			Meeting lastFlatCalendarMeeting= flatCalendar.get(flatCalendar.size()-1);
			if(current.getStart() <= lastFlatCalendarMeeting.getEnd()) {
				int startOfFlat= lastFlatCalendarMeeting.getStart();
				if(current.getEnd() <= lastFlatCalendarMeeting.getEnd()) {
					Meeting m= new Meeting(startOfFlat,lastFlatCalendarMeeting.getEnd());
					//System.out.println(m.getStart() + " jdjdj " +m.getEnd());
					flatCalendar.set((flatCalendar.size()-1), m);
					
					//flatCalendar.forEach(lm -> {System.out.println(lm.getStart()+ "inside " +lm.getEnd());});
				}
				else {
					Meeting m= new Meeting(startOfFlat,current.getEnd());
					//System.out.println(m.getStart() + " hhhjdjdj " +m.getEnd());
					flatCalendar.set((flatCalendar.size()-1), m);
					//flatCalendar.forEach(lm -> {System.out.println(lm.getStart()+ "inn " +lm.getEnd());});
				}
					
			}
			else {
				flatCalendar.add(current);
				//flatCalendar.forEach(m -> {System.out.println(m.getStart()+ "else " +m.getEnd());});
			}
			
		}
		
		/*System.out.println(" hh");
		flatCalendar.forEach(m -> {System.out.println(m.getStart()+ " " +m.getEnd());});
		
		System.out.println("jjjjjjj");*/
		return flatCalendar;
	}

	private static List<Meeting> convertingCalendar(List<StringMeeting> updatedCal2) {
		
		List<Meeting> converted= new ArrayList<Meeting>();
		for(int i=0;i< updatedCal2.size();i++) {
			converted.add(new Meeting(timeToMinute(updatedCal2.get(i).start),timeToMinute(updatedCal2.get(i).end)));
		}
		//converted.forEach(m -> {System.out.println(m.getStart()+ " " +m.getEnd());});
		return converted;
	}

	private static int timeToMinute(String time) {
		
		int hours= Integer.parseInt(time.split(":")[0]);
		int min= Integer.parseInt(time.split(":")[1]);
		
		return hours*60 +min;
	}

	private static List<Meeting> mergingCalendar(List<Meeting> convertCalendar1, List<Meeting> convertCalendar2) {

		List<Meeting> mergedCal= new ArrayList<Meeting>();
		int i=0,j=0;
		while(i < convertCalendar1.size() && j < convertCalendar2.size()) {
			if(convertCalendar1.get(i).getStart() <= convertCalendar2.get(j).getStart()) {
				mergedCal.add(convertCalendar1.get(i));
				i++;
			}
			else {
				mergedCal.add(convertCalendar2.get(j));
				j++;
			}
				
		}
		
		while(i< convertCalendar1.size())
		{
			mergedCal.add(convertCalendar1.get(i));
			i++;
		}
		
		while(j< convertCalendar2.size())
		{
			mergedCal.add(convertCalendar2.get(j));
			j++;
		}
		//System.out.println(" ");
		//mergedCal.forEach(m -> {System.out.println(m.getStart()+ " " +m.getEnd());});
		return mergedCal;
	}


	static class StringMeeting {
	    public String start;
	    public String end;

	    public StringMeeting(String start, String end) {
	      this.start = start;
	      this.end = end;
	    }
	  }
	
	static class Meeting {
	    public int start;
	    public int end;

	    public Meeting(int start, int end) {
	      this.start = start;
	      this.end = end;
	    }
	    
	    public int getStart() {
	    	return this.start;
	    }
	    
	    public int getEnd() {
	    	return this.end;
	    }
	  }

}


