package com.goeckeler.bootcamp.domain.artists.object;

import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

import com.goeckeler.bootcamp.common.object.EntitySet;

@Embeddable
public class Artists
  extends EntitySet<Artist>
{
  @OneToMany
  private Set<Artist> artists;

  @Override
  protected Set<Artist> data() {
    return artists;
  }

  @Override
  protected void data(final Set<Artist> set) {
    this.artists = set;
  }
}
