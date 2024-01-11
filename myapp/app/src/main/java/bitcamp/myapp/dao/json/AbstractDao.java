package bitcamp.myapp.dao.json;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T> {

    protected ArrayList<T> list;
    private String filepath;

    public AbstractDao(String filepath) {
        this.filepath = filepath;
        loadData();
    }


    protected void loadData() {

        try (BufferedReader in = new BufferedReader(new FileReader(filepath))) {

            // 파일에서 JSON 문자열을 모두 읽어서 버퍼에 저장한다.
            StringBuilder strBuilder = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                strBuilder.append(str);
            }

            // 버퍼에 저장된 JSON 문자열을 가지고 컬렉션 객체를 생성한다.
            return (List<E>) new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(
                    strBuilder.toString(),
                    TypeToken.getParameterized(ArrayList.class, clazz));

        } catch (Exception e) {
            System.out.printf("%s 파일 로딩 중 오류 발생!\n", filepath);
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
