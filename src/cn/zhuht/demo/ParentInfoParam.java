package cn.zhuht.demo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author zhuhaitao
 * @date 2019/7/19 15:26
 */
@Data
@Accessors
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParentInfoParam {
  //负责人
  List<String> owners;
  //筛选开始时间
  LocalDate startDate;
  //筛选结束时间
  LocalDate endDate;
  //搜索条件：key可选 姓名、负责人、共享人、变动动作、联系方式、信息来源
  Map<String, String> search;
  //标签 同组标签放在一个list里
  //List<List<String>> signs;
  Map<String, List<String>> signs;
}
