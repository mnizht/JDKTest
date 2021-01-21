package cn.zhuht.demo;

import lombok.AccessLevel;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author zhuhaitao
 * @date 2019/7/19 15:26
 */
@Accessors
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParentInfoParam {
  //负责人
  private List<String> owners;
  //筛选开始时间
  private LocalDate startDate;
  //筛选结束时间
  private LocalDate endDate;
  //搜索条件：key可选 姓名、负责人、共享人、变动动作、联系方式、信息来源
  private Map<String, String> search;
  //标签 同组标签放在一个list里
  //List<List<String>> signs;
  private Map<String, List<String>> signs;

  public ParentInfoParam() {
  }

  public List<String> getOwners() {
    return this.owners;
  }

  public LocalDate getStartDate() {
    return this.startDate;
  }

  public LocalDate getEndDate() {
    return this.endDate;
  }

  public Map<String, String> getSearch() {
    return this.search;
  }

  public Map<String, List<String>> getSigns() {
    return this.signs;
  }

  public void setOwners(List<String> owners) {
    this.owners = owners;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public void setSearch(Map<String, String> search) {
    this.search = search;
  }

  public void setSigns(Map<String, List<String>> signs) {
    this.signs = signs;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof ParentInfoParam)) return false;
    final ParentInfoParam other = (ParentInfoParam) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$owners = this.getOwners();
    final Object other$owners = other.getOwners();
    if (this$owners == null ? other$owners != null : !this$owners.equals(other$owners)) return false;
    final Object this$startDate = this.getStartDate();
    final Object other$startDate = other.getStartDate();
    if (this$startDate == null ? other$startDate != null : !this$startDate.equals(other$startDate)) return false;
    final Object this$endDate = this.getEndDate();
    final Object other$endDate = other.getEndDate();
    if (this$endDate == null ? other$endDate != null : !this$endDate.equals(other$endDate)) return false;
    final Object this$search = this.getSearch();
    final Object other$search = other.getSearch();
    if (this$search == null ? other$search != null : !this$search.equals(other$search)) return false;
    final Object this$signs = this.getSigns();
    final Object other$signs = other.getSigns();
    if (this$signs == null ? other$signs != null : !this$signs.equals(other$signs)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof ParentInfoParam;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $owners = this.getOwners();
    result = result * PRIME + ($owners == null ? 43 : $owners.hashCode());
    final Object $startDate = this.getStartDate();
    result = result * PRIME + ($startDate == null ? 43 : $startDate.hashCode());
    final Object $endDate = this.getEndDate();
    result = result * PRIME + ($endDate == null ? 43 : $endDate.hashCode());
    final Object $search = this.getSearch();
    result = result * PRIME + ($search == null ? 43 : $search.hashCode());
    final Object $signs = this.getSigns();
    result = result * PRIME + ($signs == null ? 43 : $signs.hashCode());
    return result;
  }

  public String toString() {
    return "ParentInfoParam(owners=" + this.getOwners() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ", search=" + this.getSearch() + ", signs=" + this.getSigns() + ")";
  }
}
