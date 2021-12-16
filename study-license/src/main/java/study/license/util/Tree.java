package study.license.util;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Tree implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_ROOT_ID = "0";
    private static final String DEFAULT_ROOT_TEXT = "ROOT";
    public static final Tree DEFAULT_ROOT = builder().id("0").text("ROOT").build();
    private String id;
    private String text;
    private boolean expand;
    private boolean checked;
    private boolean disabled;
    private String parentId;
    private boolean hasParent;
    private boolean hasChildren;
    private List<Tree> children;
    private boolean hasAttribute;
    private Map<String, Object> attributes;

    private boolean calculateHasParent() {
        return this.parentId != null && this.parentId.trim().length() > 0;
    }

    private boolean calculateHasChildren() {
        return this.children != null && !this.children.isEmpty();
    }

    private boolean calculateHasAttribute() {
        return this.attributes != null && !this.attributes.isEmpty();
    }

    public static <T> Tree of(Collection<T> nodes, Function<T, Tree> convert, Tree rootNode) {
        List<Tree> listOrig = (List)((Collection) Optional.ofNullable(nodes).orElse(Collections.emptyList())).stream().map(convert).peek((tn) -> {
            ((Tree) tn).setId(defaultIfBlank(((Tree) tn).getId(), rootNode.getId()));
        }).peek((tn) -> {
            ((Tree) tn).setText(defaultIfBlank(((Tree) tn).getText(), rootNode.getText()));
        }).collect(Collectors.toList());
        processChildrenNode(listOrig, rootNode);
        return rootNode;
    }

    public static <T> Tree of(Collection<T> nodes, Function<T, Tree> convert, String rootId, String rootText) {
        Tree rootNode = new Tree();
        rootNode.setId(rootId);
        rootNode.setText(rootText);
        rootNode.setExpand(true);
        return of(nodes, convert, rootNode);
    }

    public static <T> Tree of(Collection<T> nodes, Function<T, Tree> convert, String rootText) {
        return of(nodes, convert, "0", rootText);
    }

    public static <T> Tree of(Collection<T> nodes, Function<T, Tree> convert) {
        return of(nodes, convert, "0", "ROOT");
    }

    private static void processChildrenNode(List<Tree> listOrig, Tree node) {
        List<Tree> childrens = (List)listOrig.stream().filter((no) -> {
            return no.getParentId().equals(node.getId());
        }).peek((no) -> {
            no.setHasParent(true);
            no.setParentId(node.getId());
            processChildrenNode(listOrig, no);
        }).collect(Collectors.toList());
        if (!childrens.isEmpty()) {
            node.setHasChildren(true);
            node.setChildren(childrens);
        }
    }

    private static String defaultIfBlank(String str, String defaultStr) {
        if (str == null) {
            return defaultStr;
        } else {
            return str.trim().isEmpty() ? defaultStr : str;
        }
    }

    private static boolean $default$expand() {
        return false;
    }

    private static boolean $default$checked() {
        return false;
    }

    private static boolean $default$disabled() {
        return false;
    }

    private static boolean $default$hasAttribute() {
        return false;
    }

    public static TreeBuilder builder() {
        return new TreeBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public boolean isExpand() {
        return this.expand;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isDisabled() {
        return this.disabled;
    }

    public String getParentId() {
        return this.parentId;
    }

    public boolean isHasParent() {
        return this.hasParent;
    }

    public boolean isHasChildren() {
        return this.hasChildren;
    }

    public List<Tree> getChildren() {
        return this.children;
    }

    public boolean isHasAttribute() {
        return this.hasAttribute;
    }

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public void setExpand(final boolean expand) {
        this.expand = expand;
    }

    public void setChecked(final boolean checked) {
        this.checked = checked;
    }

    public void setDisabled(final boolean disabled) {
        this.disabled = disabled;
    }

    public void setParentId(final String parentId) {
        this.parentId = parentId;
    }

    public void setHasParent(final boolean hasParent) {
        this.hasParent = hasParent;
    }

    public void setHasChildren(final boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public void setChildren(final List<Tree> children) {
        this.children = children;
    }

    public void setHasAttribute(final boolean hasAttribute) {
        this.hasAttribute = hasAttribute;
    }

    public void setAttributes(final Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Tree)) {
            return false;
        } else {
            Tree other = (Tree)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Tree;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        return result;
    }

    private Tree() {
        this.expand = $default$expand();
        this.checked = $default$checked();
        this.disabled = $default$disabled();
        this.hasAttribute = $default$hasAttribute();
    }

    private Tree(final String id, final String text, final boolean expand, final boolean checked, final boolean disabled, final String parentId, final boolean hasParent, final boolean hasChildren, final List<Tree> children, final boolean hasAttribute, final Map<String, Object> attributes) {
        this.id = id;
        this.text = text;
        this.expand = expand;
        this.checked = checked;
        this.disabled = disabled;
        this.parentId = parentId;
        this.hasParent = hasParent;
        this.hasChildren = hasChildren;
        this.children = children;
        this.hasAttribute = hasAttribute;
        this.attributes = attributes;
    }

    public static class TreeBuilder {
        private String id;
        private String text;
        private boolean expand$set;
        private boolean expand$value;
        private boolean checked$set;
        private boolean checked$value;
        private boolean disabled$set;
        private boolean disabled$value;
        private String parentId;
        private boolean hasParent;
        private boolean hasChildren;
        private ArrayList<Tree> children;
        private boolean hasAttribute$set;
        private boolean hasAttribute$value;
        private ArrayList<String> attributes$key;
        private ArrayList<Object> attributes$value;

        TreeBuilder() {
        }

        public TreeBuilder id(final String id) {
            this.id = id;
            return this;
        }

        public TreeBuilder text(final String text) {
            this.text = text;
            return this;
        }

        public TreeBuilder expand(final boolean expand) {
            this.expand$value = expand;
            this.expand$set = true;
            return this;
        }

        public TreeBuilder checked(final boolean checked) {
            this.checked$value = checked;
            this.checked$set = true;
            return this;
        }

        public TreeBuilder disabled(final boolean disabled) {
            this.disabled$value = disabled;
            this.disabled$set = true;
            return this;
        }

        public TreeBuilder parentId(final String parentId) {
            this.parentId = parentId;
            return this;
        }

        public TreeBuilder hasParent(final boolean hasParent) {
            this.hasParent = hasParent;
            return this;
        }

        public TreeBuilder hasChildren(final boolean hasChildren) {
            this.hasChildren = hasChildren;
            return this;
        }

        public TreeBuilder child(final Tree child) {
            if (this.children == null) {
                this.children = new ArrayList();
            }

            this.children.add(child);
            return this;
        }

        public TreeBuilder children(final Collection<? extends Tree> children) {
            if (children == null) {
                throw new NullPointerException("children cannot be null");
            } else {
                if (this.children == null) {
                    this.children = new ArrayList();
                }

                this.children.addAll(children);
                return this;
            }
        }

        public TreeBuilder clearChildren() {
            if (this.children != null) {
                this.children.clear();
            }

            return this;
        }

        public TreeBuilder hasAttribute(final boolean hasAttribute) {
            this.hasAttribute$value = hasAttribute;
            this.hasAttribute$set = true;
            return this;
        }

        public TreeBuilder attribute(final String attributeKey, final Object attributeValue) {
            if (this.attributes$key == null) {
                this.attributes$key = new ArrayList();
                this.attributes$value = new ArrayList();
            }

            this.attributes$key.add(attributeKey);
            this.attributes$value.add(attributeValue);
            return this;
        }

        public TreeBuilder attributes(final Map<? extends String, ? extends Object> attributes) {
            if (attributes == null) {
                throw new NullPointerException("attributes cannot be null");
            } else {
                if (this.attributes$key == null) {
                    this.attributes$key = new ArrayList();
                    this.attributes$value = new ArrayList();
                }

                Iterator var2 = attributes.entrySet().iterator();

                while (var2.hasNext()) {
                    Map.Entry<? extends String, ? extends Object> $lombokEntry = (Map.Entry) var2.next();
                    this.attributes$key.add($lombokEntry.getKey());
                    this.attributes$value.add($lombokEntry.getValue());
                }

                return this;
            }
        }

        public TreeBuilder clearAttributes() {
            if (this.attributes$key != null) {
                this.attributes$key.clear();
                this.attributes$value.clear();
            }

            return this;
        }

        public Tree build() {
            List children;
            switch (this.children == null ? 0 : this.children.size()) {
                case 0:
                    children = Collections.emptyList();
                    break;
                case 1:
                    children = Collections.singletonList(this.children.get(0));
                    break;
                default:
                    children = Collections.unmodifiableList(new ArrayList(this.children));
            }

            Map attributes;
            switch (this.attributes$key == null ? 0 : this.attributes$key.size()) {
                case 0:
                    attributes = Collections.emptyMap();
                    break;
                case 1:
                    attributes = Collections.singletonMap(this.attributes$key.get(0), this.attributes$value.get(0));
                    break;
                default:
                    attributes = new LinkedHashMap(this.attributes$key.size() < 1073741824 ? 1 + this.attributes$key.size() + (this.attributes$key.size() - 3) / 3 : 2147483647);

                    for (int $i = 0; $i < this.attributes$key.size(); ++$i) {
                        attributes.put(this.attributes$key.get($i), this.attributes$value.get($i));
                    }

                    attributes = Collections.unmodifiableMap(attributes);
            }

            boolean expand$value = this.expand$value;
            if (!this.expand$set) {
                expand$value = Tree.$default$expand();
            }

            boolean checked$value = this.checked$value;
            if (!this.checked$set) {
                checked$value = Tree.$default$checked();
            }

            boolean disabled$value = this.disabled$value;
            if (!this.disabled$set) {
                disabled$value = Tree.$default$disabled();
            }

            boolean hasAttribute$value = this.hasAttribute$value;
            if (!this.hasAttribute$set) {
                hasAttribute$value = Tree.$default$hasAttribute();
            }

            return new Tree(this.id, this.text, expand$value, checked$value, disabled$value, this.parentId, this.hasParent, this.hasChildren, children, hasAttribute$value, attributes);
        }

        @Override
        public String toString() {
            return "Tree.TreeBuilder(id=" + this.id + ", text=" + this.text + ", expand$value=" + this.expand$value + ", checked$value=" + this.checked$value + ", disabled$value=" + this.disabled$value + ", parentId=" + this.parentId + ", hasParent=" + this.hasParent + ", hasChildren=" + this.hasChildren + ", children=" + this.children + ", hasAttribute$value=" + this.hasAttribute$value + ", attributes$key=" + this.attributes$key + ", attributes$value=" + this.attributes$value + ")";
        }
    }
}
