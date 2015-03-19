package com.goeckeler.bootcamp.common.object;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Supports a set to be an object.
 * 
 * @param <T> the entity type contained in the set.
 */
public abstract class EntitySet<T>
{
  public EntitySet() {
    super();
  }

  protected abstract Set<T> data();
  protected abstract void data(final Set<T> set);
  
  /**
   * Use for write access to the set of artists.
   * 
   * @return the list of artists, never <code>null</code>
   */
  private Set<T> set() {
    if (data() == null) {
      data(new TreeSet<>());
    }
    return data();
  }

  /**
   * Read-only list of all artists.
   * 
   * @return the current list of artists, never <code>null</code>
   */
  public final Set<T> all() {
    return SetUtils.unmodifiableSet(SetUtils.emptyIfNull(data()));
  }

  public final int size() {
    return all().size();  
  }

  public final boolean add(T item) {
    return set().add(item);
  }

  public final boolean remove(T item) {
    return set().remove(item);
  }

  public final boolean contains(T item) {
    return set().contains(item);
  }
  
  public final void clear() {
    set().clear();
  }
  
  public final boolean addAll(final Collection<T> collection) {
    return set().addAll(collection);
  }
  
  public final void forAll(final Iterable<T> collection) {
    this.clear();
    collection.forEach(item -> this.add(item));
  }
  
  @Override
  public String toString() {
    return StringUtils.join(set(), ", ");
  }
}
