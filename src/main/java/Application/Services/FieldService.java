package Application.Services;

import Application.DataModel.Field;
import Application.DataModel.FieldRepo;
import Application.DataModel.ProfRepo;
import Application.DataModel.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FieldService {
    @Autowired
    FieldRepo repository;

    public List<Field> getAllFields()
    {
        List<Field> result = (List<Field>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Field>();
        }
    }

    public void createField(){

    }

    public void deleteField(String field){

    }
}
