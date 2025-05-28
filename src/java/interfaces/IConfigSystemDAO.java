package interfaces;

import java.util.ArrayList;

import dto.SystemConfig;

public interface IConfigSystemDAO {
    public ArrayList<SystemConfig> getList();
    public int updateConfig();
}
