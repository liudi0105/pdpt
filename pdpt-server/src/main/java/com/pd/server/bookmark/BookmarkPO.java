package com.pd.server.bookmark;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "bookmarks")
public class BookmarkPO {
    @Id
    private Integer id;
    private Integer torrentid;
    private Integer userid;
}
