package test.study.hadoop.map;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author sunYang
 * @Date 2020/9/29
 */
public class WordCountMap extends Mapper<LongWritable, Text, Text, LongWritable> {

    @Override
    protected void map(LongWritable k2, Text v2, Context context) throws IOException, InterruptedException {
        /*
         * context表示Mapper上下文
         * 上文：HDFS
         * 下文：Reducer
         */
        //得到从HDFS读入的数据: I love Beijing
        String str = v2.toString();
        //分词
        String[] words = str.split(" ");
        //输出到Reducer：元组对：(I,1)
        for(String w:words){
            // k2:单词 v2:记一次数
            context.write(new Text(w), new LongWritable(1));
        }
    }
}
