package cn.zhuht.jdk8test.pojo.enumattribute;

/**
 * author zhuhaitao
 * date 2019/3/27 14:48
 *
 **/
public enum VarietyDog {

  Akita("秋田犬"),
  AlaskanMalamute("阿拉斯加雪橇犬"),
  AmericanEskimoDog("美国爱斯基摩犬"),
  BorderCollie("边境牧羊犬"),
  BullTerrier("牛头梗"),
  Chihuahua("吉娃娃"),
  ChineseSharPei("中国沙皮犬"),
  ChowChow("松狮犬"),
  Collie("牧羊犬"),
  Dachshund("腊肠犬"),
  Dalmatian("斑点犬"),
  GermanShepherdDog("德国牧羊犬"),
  GoldenRetriever("黄金猎犬"),
  LabradorRetriever("拉布拉多犬"),
  Pekingese("北京犬"),
  Poodle("贵妇犬"),
  Samoyed("萨摩犬"),
  TibetanSpaniel("西藏猎犬");

  private String text;

  VarietyDog(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
