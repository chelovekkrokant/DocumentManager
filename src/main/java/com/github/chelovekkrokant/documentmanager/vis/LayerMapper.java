package com.github.chelovekkrokant.documentmanager.vis;

import com.github.chelovekkrokant.documentmanager.entity.DocumentEntity;
import com.github.chelovekkrokant.documentmanager.vis.impl.DocumentModelImpl;

public interface LayerMapper {
    DocumentModelImpl mapRepoToVis(DocumentEntity entity);

    DocumentEntity mapVisToRepo(DocumentModelImpl item);
}
