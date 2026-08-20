import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

public class P06_AlarmUnitTesting {



    @Test
    public void whenTyrePressureIsLessThan17_thenThenAlarmIsOn(){

        //Не искам истински сензор!!!
        //Искам да имам обект, на който аз да му казвам как да се държи
        //мокнат обект, който лесно мода да манипулирам
        Sensor sensor = Mockito.mock(Sensor.class);

        Alarm alarm = new Alarm(sensor);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.00);

        alarm.check();

        Assertions.assertTrue(alarm.getAlarmOn());

    }

    @Test
    public void whenTyrePressureIsMoreThan21_thenThenAlarmIsOn(){

        //Не искам истински сензор!!!
        //Искам да имам обект, на който аз да му казвам как да се държи
        //мокнат обект, който лесно мода да манипулирам
        Sensor sensor = Mockito.mock(Sensor.class);

        Alarm alarm = new Alarm(sensor);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(23.00);

        alarm.check();

        Assertions.assertTrue(alarm.getAlarmOn());

    }

    @Test
    public void whenTyrePressureIsBTW17And21_thenAlarmIsOff(){

        //Не искам истински сензор!!!
        //Искам да имам обект, на който аз да му казвам как да се държи
        //мокнат обект, който лесно мода да манипулирам
        Sensor sensor = Mockito.mock(Sensor.class);

        Alarm alarm = new Alarm(sensor);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(20.00);

        alarm.check();

        Assertions.assertFalse(alarm.getAlarmOn());
    }

}
