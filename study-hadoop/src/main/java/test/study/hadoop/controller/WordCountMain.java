package test.study.hadoop.controller;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import test.study.hadoop.map.WordCountMap;
import test.study.hadoop.reduce.WordCountReduce;

/**
 * @author sunYang
 * @Date 2020/9/29
 */
public class WordCountMain {

    public static void main(String[] args) throws Exception{
        // 创建一个job = mapper + reducer
        //Job job = new Job(new Configuration());//过期的方法
        Job job = Job.getInstance(new Configuration());
        //指定任务的入口
        job.setJarByClass(WordCountMain.class);
        //指定任务的mapper，和输出的数据类型
        job.setMapperClass(WordCountMap.class);
        job.setMapOutputKeyClass(Text.class); //就是k2的数据类型
        job.setMapOutputValueClass(LongWritable.class); //就是v2的数据类型
        //指定任务的reducer，和输出的数据类型
        job.setReducerClass(WordCountReduce.class);
        job.setOutputKeyClass(Text.class); //就是k4的数据类型
        job.setOutputValueClass(LongWritable.class);//就是v4的数据类型
        //指定输入和输出目录：HDFS的路径
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        //执行任务，true表示执行过程中打印日志，false表示不打印日志
        job.waitForCompletion(true);
    }

}
