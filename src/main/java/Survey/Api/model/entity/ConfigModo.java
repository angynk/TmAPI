package Survey.Api.model.entity;

import Survey.Api.model.entity.db.Modo;

import java.util.List;


public class ConfigModo {

    private List<Modo> modos;

    public ConfigModo() {
    }

    public List<Modo> getModos() {
        return modos;
    }

    public void setModos(List<Modo> modos) {
        this.modos = modos;
    }
}
