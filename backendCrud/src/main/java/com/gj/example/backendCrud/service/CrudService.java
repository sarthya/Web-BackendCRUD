package com.gj.example.backendCrud.service;

import com.gj.example.backendCrud.entity.FamilyNodeEntity;
import com.gj.example.backendCrud.model.FamilyNode;
import com.gj.example.backendCrud.repository.CrudRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrudService {
    @Autowired
    CrudRepository repository;

    public FamilyNode invokeSaveOperation(FamilyNode request) {
        FamilyNodeEntity entity = new FamilyNodeEntity();
        BeanUtils.copyProperties(request, entity);
        BeanUtils.copyProperties(repository.save(entity), request);
        return request;
    }

    public FamilyNode getFamilyData(Long id) {
        FamilyNode response = new FamilyNode();
        BeanUtils.copyProperties(repository.findById(id).get(), response);
        return response;
    }

    public List<FamilyNode> getFamilyDataList() {
        return repository.findAll().stream().map(entity -> {
            FamilyNode node = new FamilyNode();
            BeanUtils.copyProperties(entity, node);
            return node;
        }).collect(Collectors.toList());
    }
}
