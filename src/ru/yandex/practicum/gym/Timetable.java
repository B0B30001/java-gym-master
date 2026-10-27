package ru.yandex.practicum.gym;

import java.util.*;

public class Timetable {

    private Map<DayOfWeek, ArrayList<TrainingSession>> timetable = new HashMap<>();

    public void addNewTrainingSession(TrainingSession trainingSession) {
        //сохраняем занятие в расписании
        if(timetable.containsKey(trainingSession.getDayOfWeek())) {
            timetable.get(trainingSession.getDayOfWeek()).add(trainingSession);
        } else {
            ArrayList<TrainingSession> trainingSessions = new ArrayList<>();
            trainingSessions.add(trainingSession);
            timetable.put(trainingSession.getDayOfWeek(), trainingSessions);
        }
    }

    public ArrayList<TrainingSession> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        //как реализовать, тоже непонятно, но сложность должна быть О(1)
        return timetable.get(dayOfWeek);
    }

    public TrainingSession getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        //как реализовать, тоже непонятно, но сложность должна быть О(1)
        ArrayList<TrainingSession> trainingSessions = timetable.get(dayOfWeek);
        for (TrainingSession trainingSession : trainingSessions) {
            if (trainingSession.getTimeOfDay().equals(timeOfDay)) {
                return trainingSession;
            }
        }
        return null;
    }

    HashMap<Coach, Integer> getCountByCoaches(Coach coach) {
        HashMap<Coach, Integer> countByCoaches = new HashMap<>();
        for (ArrayList<TrainingSession> trainingSessions : timetable.values()) {
            for (TrainingSession trainingSession : trainingSessions) {
                if (trainingSession.getCoach().equals(coach)) {
                    countByCoaches.put(coach, countByCoaches.getOrDefault(coach, 0) + 1);
                }
            }
        }
        return countByCoaches;

    }

}
