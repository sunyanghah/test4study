package study.mysql.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.mysql.config.IdGenerator;
import study.mysql.entity.*;
import study.mysql.service.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author sunYang
 * @Date 2020-12-18
 */
@Service
public class InitDataServiceImpl implements InitDataService {

    @Resource
    private IGradeService gradeService;
    @Resource
    private ITeacherService teacherService;
    @Resource
    private IStudentService studentService;
    @Resource
    private IClassesService classesService;
    @Resource
    private IClassTeacherService classTeacherService;
    @Resource
    private IdGenerator idGenerator;

    @Override
    public void initData() {
        List<Long> gradeIdList = initGrade();
        List<Long> classIdList = initClasses(gradeIdList);
        initTeacher(classIdList);
        initStudent(classIdList);
    }
    @Transactional(rollbackFor = Exception.class)
    public List<Long> initGrade(){

        List<Grade> gradeList = new ArrayList<>();
        for (long i = 1L;i<100;i++){
            Grade grade = new Grade();
            grade.setId(i);
            grade.setName("年级"+i);
            gradeList.add(grade);
        }

        gradeService.saveBatch(gradeList);

        return gradeList.stream().map(grade -> grade.getId()).collect(Collectors.toList());

    }
    @Transactional(rollbackFor = Exception.class)
    public void initTeacher(List<Long> classIds){

        List<Teacher> teacherList = new ArrayList<>();
        Random random = new Random();
        for (long i = 1L;i<300;i++){
            Teacher teacher = new Teacher();
            teacher.setId(i);
            teacher.setName("老师"+i);
            teacher.setLevel(String.valueOf(random.nextInt(4)));
            teacher.setSubject(String.valueOf(random.nextInt(10)));
            teacherList.add(teacher);

            List<ClassTeacher> classesTeacherList = new ArrayList<>();
            List<Long> hasList = new ArrayList<>();
            for (long j = 1L;j<100;j++){
                ClassTeacher classTeacher = new ClassTeacher();
                classTeacher.setId(idGenerator.next());
                Long classId = classIds.get(random.nextInt(classIds.size()));
                while (hasList.contains(classId)){
                    classId = classIds.get(random.nextInt(classIds.size()));
                }
                hasList.add(classId);
                classTeacher.setClassId(classId);
                classTeacher.setTeacherId(i);
                classesTeacherList.add(classTeacher);
            }
            hasList.clear();
            classTeacherService.saveBatch(classesTeacherList);

        }

        teacherService.saveBatch(teacherList);

    }
    @Transactional(rollbackFor = Exception.class)
    public List<Long> initClasses(List<Long> gradeIds){

        List<Classes> classesList = new ArrayList<>();

        Random random = new Random();

        for (long i = 1L;i<1000;i++){
            Classes classes = new Classes();
            classes.setId(i);
            classes.setName("班级"+i);
            classes.setGradeId(gradeIds.get(random.nextInt(gradeIds.size())));
            classes.setDescription("description"+i);
            classesList.add(classes);
        }

        classesService.saveBatch(classesList);

        return classesList.stream().map(grade -> grade.getId()).collect(Collectors.toList());

    }
    @Transactional(rollbackFor = Exception.class)
    public void initStudent(List<Long> classIds){

        List<Student> studentList = new ArrayList<>();

        Random random = new Random();

        for (long i = 1L;i<50000;i++){
            Student student = new Student();
            student.setId(i);
            student.setName("学生"+i);
            student.setAge(random.nextInt(30));
            student.setAddress("address"+i);
            student.setGender(String.valueOf(random.nextInt(2)));
            student.setTelephone("1"+new BigDecimal(random.nextDouble()).multiply(new BigDecimal(10000000000L)).setScale(0,BigDecimal.ROUND_HALF_UP).toString());
            student.setClassId(classIds.get(random.nextInt(classIds.size())));
            studentList.add(student);
        }

        studentService.saveBatch(studentList);

    }



}
