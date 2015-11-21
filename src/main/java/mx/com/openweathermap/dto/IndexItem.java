package mx.com.openweathermap.dto;

import java.util.List;

/**
 * Created by beto on 21/11/2015.
 */
public class IndexItem {

  private String linkReference;
  private String title;
  private List<IndexItem> childs;

  public IndexItem() {
  }

  public String getLinkReference() {
    return linkReference;
  }

  public void setLinkReference(String linkReference) {
    this.linkReference = linkReference;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<IndexItem> getChilds() {
    return childs;
  }

  public void setChilds(List<IndexItem> childs) {
    this.childs = childs;
  }

  @Override
  public String toString() {
    return "IndexItem{" +
        "linkReference='" + linkReference + '\'' +
        ", title='" + title + '\'' +
        ", childs=" + childs +
        '}';
  }
}
