package com.sirun.entityenum;

/**
 * Company: 斯润天朗（北京）科技有限公司
 * @author liyintao
 * @date 2017年3月3日 下午4:31:13
 */
public enum AlertEnum {
	HVBATCELLTEMOVERDIFF("温度差异报警","0"),
	DISHRGHVBATCELLOVERTEMSTS("电池极柱高温报警","1"),
	HVBATPACKOVERVOLSTS("动力蓄电池包过压报警","2"),
	HVBATPACKUNDERVOLSTS("动力蓄电池包欠压报警","3"),
	CLSTRSOCSTS("SOC低报警","4"),
	HVBATCELLOVERVOLSTS("单体蓄电池过压报警","5"),
	HVBATCELLUNDERVOLSTS("单体蓄电池欠压报警","6"),
	CLSTRSOCSTSHIGH("SOC太低报警","7"),
	CLSTRSOCSTSLOW("SOC跳变报警","8"),
	DYNHVBATCELLVOLDIFFSTS1("动力蓄电池包不匹配报警","9"),
	DYNHVBATCELLVOLDIFFSTS2("动力蓄电池一致性差报警","10"),
	HVBATISLTNF("绝缘故障","11"),
	DCDCSTSERRLVL("DC-DC温度报警","12"),
	ABSF("制动系统报警","13"),
	DCDCCRHGFLT("DC-DC状态报警","14"),
	MCUOVERTEMWRNNG("电机控制器温度报警","15"),
	MOTHVILCLSD("高压互锁状态报警","16"),
	MCUELECMOTOVERTEMWRNNG("驱动电机温度报警","17"),
	HVBATERRLVL("储能系统故障","18"),
	MOTDRVRSYSFLT("电机驱动系统故障","53"),
	VEHCRSHSTS("碰撞信号状态","54"),
	DISHRGHVBATCELLUNDERTEMSTS("电池单体最低温度报警","55");
	private String alertType;
	private String alertName;
	private AlertEnum(String alertName, String alertType) {
		this.alertType = alertType;
		this.alertName = alertName;
	}
	public static String getAlertName(String alertType){
		for(AlertEnum messageEnum:AlertEnum.values()){
			if(alertType.equals(messageEnum.getAlertType())){
				return messageEnum.getAlertName();
			}
		}
		return null;
	}
	public String getAlertType() {
		return alertType;
	}
	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}
	public String getAlertName() {
		return alertName;
	}
	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}
}
