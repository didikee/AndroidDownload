package cn.sddman.download.mvp.p;

import java.util.List;

import cn.sddman.download.common.Const;
import cn.sddman.download.mvp.e.AppSettingEntity;
import cn.sddman.download.mvp.m.AppSettingModel;
import cn.sddman.download.mvp.m.AppSettingModelImp;
import cn.sddman.download.mvp.v.AppSettingView;

public class AppSettingPresenterImp implements AppSettingPresenter {
    private AppSettingView appSettingView;
    private AppSettingModel appSettingModel;
    public AppSettingPresenterImp(AppSettingView appSettingView){
        this.appSettingView=appSettingView;
        appSettingModel= new AppSettingModelImp();
        initSetting();
    }

    @Override
    public void initSetting() {
        List<AppSettingEntity> list=appSettingModel.findAllSetting();
        if(null!=list && list.size()>0) {
            for (AppSettingEntity setting : list) {
                appSettingView.initSetting(setting.getKey(), setting.getValue());
            }
        }
    }

    @Override
    public void setSavePath(String path) {
        appSettingModel.setSavePath(path);
    }

    @Override
    public void setDownCount(String count) {
        appSettingModel.setDownCount(count);
    }

    @Override
    public void setMobileNet(String net) {
        appSettingModel.setMobileNet(net);
    }
}
