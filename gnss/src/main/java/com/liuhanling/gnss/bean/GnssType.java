package com.liuhanling.gnss.bean;

import com.liuhanling.gnss.cons.Constants;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: Copyright (c) 太昌电子 2018</p>
 *
 * @author liuhanling
 * @date 2019-04-10 18:24
 */
public enum GnssType {

    GPS(1, Constants.GPS, Constants.GPGSV, Constants.MSM4_GPS),
    GLO(2, Constants.GLO, Constants.GLGSV, Constants.MSM4_GLO),
    GAL(3, Constants.GAL, Constants.GAGSV, Constants.MSM4_GAL),
    BDS(4, Constants.BDS, Constants.BDGSV, Constants.MSM4_BDS);

    private final int type;
    private final String name;
    private final String gsv;
    private final int msm;

    GnssType(int type, String name, String gsv, int msm) {
        this.type = type;
        this.name = name;
        this.gsv = gsv;
        this.msm = msm;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getGsv() {
        return gsv;
    }

    public int getMsm() {
        return msm;
    }

    public static GnssType getGnssType(int type) {
        for (GnssType gnssType : GnssType.values()) {
            if (gnssType.getType() == type) {
                return gnssType;
            }
        }
        return GPS;
    }

    public static int getType(String gsv) {
        for (GnssType type : GnssType.values()) {
            if (type.getGsv().equals(gsv)) {
                return type.getType();
            }
        }
        return GPS.getType();
    }

    public static String getSatlliteSystem(int msm) {
        for (GnssType type : GnssType.values()) {
            if (type.getMsm() == msm) {
                return type.getName();
            }
        }
        return null;
    }
}
