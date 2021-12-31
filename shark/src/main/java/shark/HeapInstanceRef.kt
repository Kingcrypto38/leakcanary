package shark

/**
 * Similar to [HeapField] but limited to non null references. References
 * can be actual fields or they can be synthetic fields when simplifying known data
 * structures.
 */
class HeapInstanceRef(
  /**
   * The class this reference was declared in.
   */
  val declaringClass: Long,

  /**
   * Name of the reference, which is either a field name or a synthetic made up value.
   */
  val name: String,

  /**
   * Object id for the object that this reference is pointing to.
   */
  val objectId: Long,

  /**
   * If true then [name] should be displayed in brackets and should be replaced with a constant when
   * computing leaktrace signatures. This enables list like and map like structures to be
   * represented as if they were arrays or dictionaries.
   */
  val isArrayLike: Boolean
)




