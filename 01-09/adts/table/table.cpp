#pragma once

#include "adts/iterable/iterable.cpp"

template <class K, class V>
class Table : public Iterable<Pair<K, V>>
{
public:
  virtual void add(K key, V value) = 0;
  virtual void remove(K key) = 0;
  virtual int size() = 0;
  virtual bool has(K key) = 0;
  virtual V get(K key) = 0;
};
