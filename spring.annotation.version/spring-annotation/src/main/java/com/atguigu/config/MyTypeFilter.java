package com.atguigu.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter {

	/**
	 * metadataReader����ǰ��(Ŀ����)��Ԫ���ݶ�ȡ��
	 * metadataReaderFactory:Ԫ���ݶ�ȡ���Ĺ�������ÿ��ԭʼ��Դ����һ��Ԫ���ݶ�ȡ��
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		//��ȡ��ǰ��ע�����Ϣ
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

		//��ȡ��ǰ����ɨ����������Ϣ
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		
		//��ȡ��ǰ����Դ�����·����
		Resource resource = metadataReader.getResource();
		
		String className = classMetadata.getClassName();
		System.out.println("--->"+className);
		if(className.contains("er")){
			return true;
		}
		return false;
	}

}
