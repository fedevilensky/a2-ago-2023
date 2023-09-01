#pragma once

template <class T>
class Iterable
{
public:
  virtual Iterator<T> *iterator() = 0;
};

template <class T>
class Iterator
{
public:
  virtual bool hasNext() = 0;
  virtual T next() = 0;
};
