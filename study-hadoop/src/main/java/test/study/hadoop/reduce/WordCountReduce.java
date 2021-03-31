package test.study.hadoop.reduce;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author sunYang
 * @Date 2020/9/29
 */
public class WordCountReduce extends Reducer<Text, LongWritable, Text, LongWritable> {

    @Override
    protected void reduce(Text k4, Iterable<LongWritable> v4, Context context) throws IOException, InterruptedException {
        /*
         * context代表reducer的上下文
         * 上文：mapper
         * 下文：HDFS
         */
        //对v3集合中的元素进行求和
        long total = 0;
        for(LongWritable v:v4){
            total = total + v.get();
        }
        //输出:<k4,v4>
        context.write(k4, new LongWritable(total));
    }
}
