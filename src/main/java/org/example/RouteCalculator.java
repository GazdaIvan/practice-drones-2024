package org.example;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculator {

    /**
     * Розумію, що доки пишуться англійською, але не став на це витрачати час, адже українською швидше, і не було таких вимог.
     * Також, в свій час писав чимало технічних документів суто українською, що на мою думку вплинуло на якість
     * описання алгоритму та інших моментів виконання ТЗ
     */

    //@Todo (1.1) додати мапу, в якій ключем будем градус, ітерація згідно з замовником...
    //@Todo (1.2)... а значення - дистанція в метрах, яке буде відповідати 1 градусу дуги відповідної ділянки (в джерелі нижче в км)
    protected final double COEFF_ONE_DEGREE_LATITUDE_PER_DISTANCE = 71700;  //в метрах //https://vseosvita.ua/library/embed/01008o7f-21dd.docx.html

    public List<TemporaryPoint> calculate(AirplaneCharacteristics characteristics, List<WayPoint> wayPoints) {
        //@todo додати всюди необхідні перевірки на NPE / ділення на нуль / і подідні edge cases

        //Алгоритм наступний
        //0 Перед цим методом у об'єкта Airplane з поля flights вивести в лог значення passedPoints (за наявності)

        //1. Приймаючи, що дві сусідні точки (WayPoint) називаємо Старт і Фініш

        //1.1 Вираховуємо загальну відстань між ними (беручи до уваги значення широти і довготи цих крайніх точок)

        //2 Знаючи відстань/дистанцію + середня усталену швидкість (поки нехтуємо набором швидкості, приймаємо, що ЛА вже рухається
        //із заданим значення) вираховуємо тривалість польоту в секундах, що буде відповідати к-сті TemporaryPoint між двома WayPoint-а

        //2.1 Тут варто зауважити, що що результат тривалості польоту може дорівнювати частрні секунди, в даному прикладі ігонрую все що менше 1 с

        //2.2 Також слід зазначити, що розрахована відстань, яку пролітає ЛА між Старт/Фініш точками без врахування набороу висоти ЛА
        //тобто нехтуємо цим (в реальності ця відстань буде дещо більшою, адже ЛА буде летіти по кривій набираючи ту необхідну висоту


        //3 Циклом працюємо з кроком 1 секунда і постійно фіксуємо зміну даних нашого ЛА, а саме його TemporaryPoint (широта та довгота)

        //3.1 Вираховуємо азимути, тобто курс польоту ЛА для кожної ітерації (course)

        //3.2 За наявності сервісу кожний крок цих ітерацій фіксуємо в БД з все новими даними нашого ЛА по TemporaryPoint (широта та довгота)


        List<Double> distances = collectAmountOfDistances(wayPoints);
        List<Double> durations = calculateDurations(characteristics, distances);

        //та весь послідуючий код описаний вище в алгоритмі

        return new ArrayList<>();       //тимчасова заглушка
    }

    private List<Double> calculateDurations(AirplaneCharacteristics characteristics, List<Double> distances) {
        List<Double> durations = new ArrayList<>();
        distances.forEach(distance -> {
            double duration = (distance / characteristics.getMaxVelocity());
            durations.add(duration);
        });
        return durations;
    }

    private List<Double> collectAmountOfDistances(List<WayPoint> wayPoints) {

        List<Double> distances = new ArrayList<>();
        for (int i = 0; i < wayPoints.size() - 1; i++) {
            WayPoint startPoint = wayPoints.get(i);         //старт
            WayPoint finishPoint = wayPoints.get(i + 1);    //фініш
            double distance = calculateDistance(startPoint.getLatitude(),
                    startPoint.getLongitude(),
                    finishPoint.getLatitude(),
                    finishPoint.getLongitude());
            distances.add(distance);
        }
        return distances;
    }

    //спрощена формула суто в прямокутній системі координат + коефіцієнт взятий для таких параметрів
    //Стартова точка (49.55 і 30.87)
    //Фінішна точка (49.41 і 31.27)
    private double calculateDistance(double latitudeStart, double longitudeStart, double latitudeFinish, double longitudeFinish) {
        double deltaLat = latitudeFinish - latitudeStart;
        double deltaLong = longitudeFinish - longitudeStart;

        return (Math.sqrt(
                Math.pow(deltaLong, 2) + Math.pow(deltaLat, 2)
        ))
                * COEFF_ONE_DEGREE_LATITUDE_PER_DISTANCE;
    }
}
