package com.sg.oracle.model.service;



import com.sg.oracle.model.entity.Calisan;

import java.util.List;

public interface VarlikService<V, I>
{
    V idyeGoreBul(I id);

    List<V> tumVarliklariCek();

    V duzenle(V calisan);

    V kaydet (V varlik);

    void sil(I id);
}
