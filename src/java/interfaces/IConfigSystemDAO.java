package interfaces;

import java.util.ArrayList;

import dto.SystemConfig;

public interface IConfigSystemDAO {
    public ArrayList<SystemConfig> getList();
    public SystemConfig getConfigByKey(String key);
    public int updateConfig(String key, String value, String desc);
}
