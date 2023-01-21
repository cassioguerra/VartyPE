package com.PIMS.PIMS.service;

import com.PIMS.PIMS.model.Vartype;
import com.PIMS.PIMS.repository.VartypeReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VartypeService {


    @Autowired
    VartypeReposytory vartypeReposytory;


    // PARA LISTAR OS VARTYPE
    public List<Vartype> finallVartyps(){
        return (List<Vartype>)  vartypeReposytory.findAll();
    }


    //pesquisa por id
    public  Vartype findVartypeById(int id){
        Optional<Vartype> result = vartypeReposytory.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        return new Vartype();
    }

    //Criar um vartype
    public  Vartype addVartype(Vartype vartype){
        return vartypeReposytory.save(vartype);
    }

    // para atualizar um vartyp
    public Vartype updateVartype(Vartype vartype){
        Optional<Vartype> result = vartypeReposytory.findById(vartype.getId());
        Vartype existing = result.get();
        existing.setName(vartype.getName());
        existing.setSiginificado(vartype.getSiginificado());
        existing.setObesavacao(vartype.getObesavacao());
        return vartypeReposytory.save(existing);
    }

    public  void  deleteById( int id){
        vartypeReposytory.deleteById(id);
    }

}
