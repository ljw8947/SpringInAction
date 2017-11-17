package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jwlv on 2017/11/2.
 */
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {

        List<Spittle> spittles= new ArrayList<Spittle>();
        for(int i=0;i<count;i++) {
            spittles.add(new Spittle("Spittle "+i,new Date()));
        }
        return  spittles;
    }

    @Override
    public Spittle findOne(long spittleId) {
        return new Spittle("this is findOne test.",new Date());
    }
}
