package com.ciandt.appofthings.util;

import java.util.ArrayList;
import java.util.List;

import com.ciandt.appofthings.domain.Local;
import com.ciandt.appofthings.domain.SensorLocal;

public class SensorLocalUtil {

	public static List<SensorLocal> getSensorLocalFromLocal(
			final List<SensorLocal> sensorLocals, final Local local) {
		List<SensorLocal> result = new ArrayList<SensorLocal>(0);

		for (SensorLocal sensorLocal : sensorLocals) {
			if (sensorLocal.getLocal().equals(local))
				result.add(sensorLocal);
		}

		return result;
	}

}
