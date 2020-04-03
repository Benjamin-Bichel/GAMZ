package Application.Services;

import Application.DataModel.Field;
import Application.DataModel.FieldRepo;
import Application.DataModel.ProfRepo;
import Application.DataModel.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void createField(Field field){
        Optional<Field> potentailField = repository.findById(field.getField());
        if(!potentailField.isPresent()){
            repository.save(field);
        }
    }

    public void deleteField(String fieldid){

    }
}
