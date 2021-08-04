package com.example.server.db;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepository<T> {

    private List<T> db = new ArrayList<>();
    private String path = "";
    private int index = 0;

    public MemoryDbRepositoryAbstract() {
        try {
            this.db = loadDb();
            this.index = this.db.size();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(row -> row.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity) {
        var optionalEntity = db.stream().filter(row -> row.getIndex() == entity.getIndex()).findFirst();

        if (optionalEntity.isEmpty()) {
            // db에 데이터가 없는 경우
            index++;
            entity.setIndex(index);
        } else {
            // db에 데이터가 있는 경우
            var preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
        }

        db.add(entity);

        try {
            writeDb();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public void deleteById(int index) {
        var optionalEntity = db.stream().filter(row -> row.getIndex() == index).findFirst();
        if (optionalEntity.isPresent()) {   // 데이터가 이미 있는경우
            db.remove(optionalEntity.get());
            try {
                writeDb();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<T> findAll() {
        return db;
    }


    private void writeDb() throws Exception {
        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        try (objectOutputStream) {
            objectOutputStream.writeObject(db);
        }
    }

    private List<T> loadDb() throws Exception {
        log.info("Load Database ...... ");

        String rootPath = System.getProperty("user.dir");
        File dir = new File(rootPath + "/database/tables/WISH_MOVIES");
        if (!dir.exists()) dir.mkdir();
        File file = new File(dir.getPath() + "/WISH_MOVIES.obj");
        path = file.getPath();

        List<T> db = new ArrayList<T>();
        if (!file.createNewFile()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            try (objectInputStream) {
                db = (ArrayList<T>) objectInputStream.readObject();
            }
        }else{
            writeDb();
        }
        log.info("Load Database FINISH!!! ");
        return db;
    }
}
