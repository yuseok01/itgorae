import styles from './[id].module.css';

const mockData = {
  id: 1,
  title: "한 입 크기로 잘라 먹는 리액트",
  subTitle: "자바스크립트 기초부터 애플리케이션 배포까지",
  description: "자바스크립트 기초부터 애플리케이션 배포까지...",
  author: "이정환",
  publisher: "프로그래밍인사이트",
  coverImgUrl: "https://shopping-phinf.pstatic.net/main_3888828/38888282618.20230913071643.jpg"
};

export default function Page() {
  const {
    id,
    title,
    subTitle,
    description,
    author,
    publisher,
    coverImgUrl,
  } = mockData;

  return (
    <div className={styles.container}>
      <div
        className={styles.cover_img_container}
        style={{ backgroundImage: `url('${coverImgUrl}')` }}
      >
        {/* Optional: If you still want to include the image as an <img> element */}
        <img src={coverImgUrl} alt={title} />
      </div>
      <div className={styles.title}>{title}</div>
      <div className={styles.subTitle}>{subTitle}</div>
      <div className={styles.author}>{author} | {publisher}</div> {/* 닫는 태그 수정됨 */}
    </div>
  );
}
